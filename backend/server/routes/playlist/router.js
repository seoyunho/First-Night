"use strict";

let express = require('express');
let router = express.Router();
let manager = require('./manager');
let http = require('http');

router.route('/playlist').post(function (req, res) {
    let title = req.body.title;
    let singer = req.body.singer;
    let musicURL = req.body.musicURL;
    let imgURL = req.body.imgURL;
    let tag = req.body.tag;
    let id = req.body.id;

    manager.addPlaylist(id, title, singer, musicURL, imgURL, function (response) {
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

router.route('/playlist/:weather').get(function (req, res) {
    let weather=req.params.weather;

    manager.getPlaylist(weather, function (response) {
        if (!!response.music) {
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

router.route('/playlist/:no').delete(function (req, res) {
    let no = req.params.no;

    manager.deletePlaylist(no, function (response) {
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

router.route('/playlist/user/:id').get(function (req, res) {
    let id=req.params.id;
    
    manager.getPlaylist(id, function (response) {
        if (!!response.music) {
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

router.route('/weather').get(function (req, res) {
    let x = req.query.x;
    let y = req.query.y;

    let response = requestAPI(x, y);
});

function requestAPI(x, y) {
    let weatherURL = "http://apis.skplanetx.com";
    let options = {
        host: weatherURL,
        path: '/weather/current/minutely?lon=' + x + '&lat=' + y + '&version=1&appKey=e9c74732-4fa4-374e-bc26-2f352d74e2fd'
    }
    http.get(options, function (res) {
        return res;
    });
}

module.exports = router;