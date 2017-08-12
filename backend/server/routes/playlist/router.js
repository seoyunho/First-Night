"use strict";

let express = require('express');
let router = express.Router();
let manager = require('./manager');
let http = require('http');
let request = require('request');

//해당 태그의 playlist 가져오기 
router.route('/playlist').get(function (req, res) {
    let tag = req.query.tag;

    manager.getPlaylist(tag, function (response) {
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

//현재 날씨 가져오기
router.route('/weather').get(function (req, res) {
    let x = req.query.x;
    let y = req.query.y;
    let response = {
        weather: null
    };

    let weather = requestAPI(x, y, function (weather) {
        response.weather = weather;
        if (!!response.weather) {
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

function requestAPI(x, y, callback) {
    request('http://apis.skplanetx.com/weather/current/minutely?lon=' + x + '&lat=' + y + '&version=1&appKey=e9c74732-4fa4-374e-bc26-2f352d74e2fd', function (error, response, body) {
        let weather = JSON.parse(body).weather.minutely[0].sky.name;
        if (weather == '구름 조금' || weather == '구름 많음' || weather == '흐림' || weather == '흐리고 낙뢰') {
            weather = '구름'
        } else if (weather == '구름많고 비' || weather == '구름많고 비 또는 눈' || weather == '흐리고 비' || weather == '흐리고 비 또는 눈' || weather == '뇌우, 비' || weather == '뇌우, 비 또는 눈') {
            weather = '비';
        } else if (weather == '구름많고 눈' || weather == '흐리고 눈' || weather == '뇌우, 눈') {
            weather = '눈'
        }
        callback(JSON.parse(body).weather.minutely[0].sky.name);
    });
}

module.exports = router;