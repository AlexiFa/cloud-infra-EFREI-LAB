from flask import Blueprint

bp = Blueprint("hello", __name__)

@bp.route("/", methods=['GET'])
def say_hello():
    return "hello"