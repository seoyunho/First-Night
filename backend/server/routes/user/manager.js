"use strict";
let conn = require('../../DBConnection');
let AES256 = require('nodejs-aes256');
const key = 'this_is_key';

let manager = {};

//회원가입
manager.signup = function (id, password, name, gender, birthday, callback) {
    let response = {
        success: false
    };

    conn.query('insert into account (id, password, name, gender, birthday) values(?,?,?,?,?);', [id, password, name, gender, birthday], function (err, result) {
        if (err) response.error = true;
        else if (result.affectedRows) response.success = true;

        callback(response);
    });
}

//로그인
manager.signin = function (id, password, callback) {
    let response = {
        success: false
    };
    let message = {};

    conn.query('select * from account where id=?', id, function (err, rows) {
        console.log(rows);
        if (err) {
            response.error = true;
            callback(response, message);
        } else if (rows.length == 1) {
            conn.query('select * from account where id=? and password=?;', [id, password], function (err, rows1) {
                if (err) {
                    callback(response, message);
                } else if (rows1.length == 1) {
                    response.success = true;
                    callback(response, message);
                } else if (rows1.length == 0) {
                    message.message = 'wrongPassword';
                    callback(response, message);
                }
            });
        } else {
            message.message = 'nonexistentId';
            callback(response, message);
        }
    });
}

//아이디 중복 체크
manager.idCheck = function (id, callback) {
    let response = {
        overlap: false
    };
    conn.query('select * from account where id=?', id, function (err, rows) {
        if (err) response.error = true;
        else if (rows.length == 1) response.overlap = true;

        callback(response);
    });
}

//전화번호 중복 체크
manager.phonecheck = function (phone, callback) {
    let response = {
        overlap: false
    };
    conn.query('select * from account where phone=?', phone, function (err, rows) {
        if (err) response.error = true;
        else if (rows.length == 1) response.overlap = true;

        callback(response);
    });
}

//비밀번호 변경
manager.updatePassword = function (id, callback) {
    let response = {
        success: false
    };

    conn.query('update account set password=? where id=?;', [id, password], function (err, result) {
        if (err) response.error = true;
        else if (reslt.affectedRows) response.success = true;

        callback(response);
    });
}

//아이디 찾기
manager.getId = function (name, phone, callback) {
    let response = {
        id: null
    };

    conn.query('select id from account where name=? and phone=?;', [name, phone], function (err, rows) {
        if (err) response.error = true;
        else if (rows.length == 1) response.id = rows[0].id;

        callback(response);
    });
}

//유저정보
manager.getUserInfo = function (id, callback) {
    let response = {
        name: null,
        id: id,
        birthday: null,
        nickname: null,
        profile: null
    };

    conn.query('select * from account where id=?', id, function (err, rows) {
        if (err) response.error = true;
        else if (rows.length == 1) {
            response.name = rows[0].name;
            response.profile = rows[0].profile;
            response.nickname =rows[0].nickname;
            response.birthday = rows[0].birthday;
        }

        callback(response);
    });
};

manager.updateUserInfo = function(naem, nickname, birthday){
    let response = {
        success: false
    }

    conn.query('update')
}

//프로필 수정
manager.putProfile = function (id, profile, callback) {
    let response = {
        success: false
    };

    conn.query('update accout set profile=? where id=?', [profile, id], function (err, result) {
        if (err) response.error = true;
        else if (result.affectedRows == 1) success = true;

        callback(response);
    });
};

//프로필 삭제
manager.deleteProfile = function (id, callback) {
    let response = {
        success: false
    };

    conn.query('update accout set profile=null where id=?', id, function (err, result) {
        if (err) response.error = true;
        else if (result.affectedRows == 1) success = true;

        callback(response);
    });
};

module.exports = manager;