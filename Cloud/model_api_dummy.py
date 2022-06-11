from flask import Flask,request,jsonify
import json

app = Flask(__name__)

root = ["label", "link"]

with open("label.json") as f:
    label = json.load(f)    
    
with open("link.json") as f:
    link = json.load(f)

@app.route('/')
def index():
    
    return jsonify(root)

@app.route('/label',methods=['GET','POST'])
def req_label():
    
    return jsonify(label)

@app.route('/link',methods=['GET','POST'])
def req_link():

    return jsonify(link)
@app.route('/link/<name>',methods=['GET','POST'])
def req_specifict_link(name):
    
    return jsonify(link[name])
        
if __name__ == '__main__':
    app.run(debug=True)
