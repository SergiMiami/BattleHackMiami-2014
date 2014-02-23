$(function() {
        
var app = document.createElement('applet');
app.id= 'Java';
app.archive= './../bin/HackForKidsApplet.jar';
app.code= './../bin/StartClass.class';
app.width = '1000';
app.height = '1000';
document.getElementsByTagName('body')[0].appendChild(app);
        
        });