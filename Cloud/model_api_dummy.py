from flask import Flask,request,jsonify

app = Flask(__name__)

with open("label.json") as f:
    label = json.load(f)
    
@app.route('/')
def index():
    return "Hello World"

@app.route('/predict',methods=['GET','POST'])
def predict():
    
    return jsonify(label)
if __name__ == '__main__':
    app.run(debug=True)