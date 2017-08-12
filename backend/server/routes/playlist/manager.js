"use strict";
let conn = require('../../DBConnection');

let manager = {};

manager.addPlaylist = function (title, singer, musicURL, imgURL, id, tag, callback) {
    let response = {
        success: false
    };

    conn.query('insert into playlist (title, singer, musicURL, imgURL, user_id) values (?,?,?,?,?)', [title, singer, musicURL, imgURL, id], function (err, result) {
        if (err) response.error = true;
        else if (result.affectRows) {
            ('select no from playlist where title=? and singer=?', [title, singer], function (err, rows) {
                if (rows.length == 1) {
                    let no = rows[0].no;
                    for (let i = 0; i < tag.length; i++) {
                        conn.query('insert into tag (no, tag) values(?,?)', [no, tag[i]], function (err, result) {
                            if (err) response.error = true;
                            else if (result.affectRows) {
                                response.success = true;
                                if (i == tag.length - 1) callback(response);
                            }
                        });
                    }
                }
            });
        }
    });
};

manager.getPlaylist = function (weather, callback) {
    let response = {
        music: []
    }

    conn.query("select * from tag where tag like '%" + weather + "%';", null, function (err, rows) {
        if (rows.length >= 0) {
            for (let i = 0; i < rows.length; i++) {
                let no = rows[i].no;
                conn.query('select * from playlist where no=?', no, function (err, rows) {
                    if (rows.length == 1) {
                        let music = {
                            no: no,
                            title: rows[0].title,
                            singer: rows[0].singer,
                            musicURL: rows[0].musicURL,
                            imgURL: rows[0].imgURL
                        };

                        response.music.push(music);
                    }
                    if (i == rows.length - 1) callback(response);
                });
            }
        }
    });
};

manager.deletePlaylist = function (no, callback) {
    let response = {
        success: false
    };

    conn.query('delete from playlist where no=?', no, function (err, result) {
        if (result.affectRows) {
            conn.query('delete from tag where no=?', no, function (err, result) {
                if (result.affectRows) response.success = true;
                callback(response);
            });
        }
    });
};

manager.getUserPlaylist = function (id, callback) {
    let response = {
        music: []
    }

    conn.query('select * from playlist where user_id=?', id, function (err, rows) {
        if (rows.length >= 0) {
            for (let i = 0; i < rows.length; i++) {
                let music = {
                    no: no,
                    title: rows[0].title,
                    singer: rows[0].singer,
                    musicURL: rows[0].musicURL,
                    imgURL: rows[0].imgURL
                };

                response.music.push(music);
            }
        }

        callback(response);
    });
}

module.exports = manager;