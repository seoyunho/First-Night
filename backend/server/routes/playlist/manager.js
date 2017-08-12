"use strict";
let conn = require('../../DBConnection');

let manager = {};

manager.getPlaylist = function (tag, callback) {
    let response = {
        music: []
    }

    conn.query("select * from tag where tag like '%" + tag + "%';", null, function (err, rows) {
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

module.exports = manager;