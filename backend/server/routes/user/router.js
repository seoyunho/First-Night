"use strict";

let express = require('express');
let router = express.Router();
let manager = require('./manager');
let AES256 = require('nodejs-aes256');
let SHA256 = require('sha256');
const key = 'this_is_key';
// let apistore = require('apistore-sms').createClient({
//     apiKey: 'YOUR_API_KEY',
//     apiId: 'YOUR_ID'
// });
let certifyString;

//회원가입
router.route('/account/signup').post(function (req, res) {
    let id = req.body.id;
    let name = req.body.name;
    let password = SHA256(req.body.password);
    let gender= req.body.gender;
    let birthday= req.body.birthday;
    
    console.log(id, name, password, phone);

    manager.signup(id, password, name, gender, birthday, function (response) {
        if (response.success) {
            res.writeHead(201, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(400, {
                'Content-Type': 'application/json'
            });
        }
        res.end();
    });
});

//로그인
router.route('/account/signin').post(function (req, res) {
    let id = req.body.id;
    let password = SHA256(req.body.password);

    manager.signin(id, password, function (response, message) {
        if (response.success) {
            res.writeHead(201, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(400, {
                'Content-Type': 'application/json'
            });
        }
        if (!!message.message) {
            res.write(JSON.stringify(message));
            res.end();
        }
        res.end();

    });
});

//아이디 중복 체크
router.route('/account/idcheck').post(function (req, res) {
    let id = req.body.id;
    manager.idCheck(id, function (response) {
        console.log(response);
        if (response.overlap) {
            res.writeHead(200, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(204, {
                'Content-Type': 'application/json'
            });
        }
        res.end();
    });
});

//전화번호 중복 체크
router.route('/account/phonecheck').post(function (req, res) {
    let phone = req.body.phone;

    manager.phonecheck(phone, function (response) {
        if (response.overlap) {
            res.writeHead(200, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(204, {
                'Content-Type': 'application/json'
            });
        }
        res.end();
    });
});

//아이디 찾기
router.route('/account/findid').get(function (req, res) {
    let name = req.body.name;
    let phone = req.body.phone;

    manager.getId(name, phone, function (response) {
        if (!!response.id) {
            res.writeHead(200, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(204, {
                'Content-Type': 'application/json'
            });
        }

        res.write(JSON.stringify(response));
        res.end();
    });
});

//비밀번호 변경
router.route('/account/findpassword').put(function (req, res) {
    let id = req.params.id;
    let password = SHA256(req.body.password);

    manager.updatePassword(id, password, function (response) {
        if (response.success) {
            res.writeHead(201, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(204, {
                'Content-Type': 'application/json'
            });
        }
        res.end();
    });
});

//유저 정보
router.route('/userinfo/:id').get(function (req, res) {
    let id = req.params.id;
    console.log(id);
    manager.getUserInfo(id, function (response) {
        res.writeHead(200, {
            'Content-Type': 'application/json'
        });
        res.write(JSON.stringify(response));
        res.end();
    });
});

//유저 정보 업데이트
router.route('/userinfo/:id').put(function (req, res) {
    
    manager.getUserInfo(id, function (response) {
        res.writeHead(200, {
            'Content-Type': 'application/json'
        });
        res.write(JSON.stringify(response));
        res.end();
    });
});

//프로필 수정
router.route('/mypage/profile/:id/').put(function (req, res) {
    let id = req.params.id;
    let profile = req.body.profile;

    manager.deleteProfile(id, profile, function (response) {
        if (response.success) {
            res.writeHead(201, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(204, {
                'Content-Type': 'application/json'
            });
        }
        res.end();
    });
});

//프로필 삭제
router.route('/mypage/profile/:id').delete(function (req, res) {
    let id = req.params.id;

    manager.deleteProfile(id, function (response) {
        if (response.success) {
            res.writeHead(201, {
                'Content-Type': 'application/json'
            });
        } else {
            res.writeHead(204, {
                'Content-Type': 'application/json'
            });
        }
        res.end();
    });
});
module.exports = router;