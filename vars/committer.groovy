#! /usr/bin/env groovy

def call(String committer){
    slackSend color: "danger", message: "$committer" 
}
