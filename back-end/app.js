var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var cors = require('cors');

app.disable('x-powered-by');

app.use(cors());

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var api = {};
api.pluviometer = require('./modules/pluviometer/routes');

app.use('/hackathon/api/v1/pluviometer', api.pluviometer);

module.exports = app;