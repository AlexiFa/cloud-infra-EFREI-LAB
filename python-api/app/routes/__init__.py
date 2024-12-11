from flask import Blueprint
from app.routes import hello

def register_routes(app):
    app.register_blueprint(hello.bp, url_prefix="/hello")