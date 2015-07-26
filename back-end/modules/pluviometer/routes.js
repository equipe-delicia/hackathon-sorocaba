var express = require('express');
var router = express.Router();
var https = require('https');

// Web API's

// Status dos reservatórios -> https://sabesp-api.herokuapp.com/
// Fluviometros -> https://pluviometer-think-make-move.appspot.com/_ah/api/pluviometer/v1/listall

var url = 'https://sabesp-api.herokuapp.com/';

router.get('/:city', function(req, res) {
	https.get(url, function(get) {
		get.on('data', function(data) {
			res.json(JSON.parse(data)[0]);
		});
	})
	.on('error', function(error) {
		res.status(500).send(error);
	});

});

module.exports = router;