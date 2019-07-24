/**
 * This script will update the version number in plugin.xml. This should be called from the `npm version` command,
 * as per these docs: https://docs.npmjs.com/cli/version.html
 *
 * Usage: node update-version-num.js <version number>
 *
 */

const fs = require('fs');
const convert = require('xml-js');

const newVersion = require('process').argv[2];

if (!newVersion) {
    console.error('Version not specified');
    process.exit(1);
}

const xmlContent = fs.readFileSync('plugin.xml', 'utf8');
const json = JSON.parse(convert.xml2json(xmlContent, { reversible: true }));
json.elements.filter(el => el.name === 'plugin')[0].attributes.version = newVersion;
fs.writeFileSync('plugin.xml', convert.js2xml(json, { spaces: 4 }));

