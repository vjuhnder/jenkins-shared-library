#!/usr/bin/env groovy

def call(String slackData) {
  if ( slackData.get(0) == "FAILURE" ) {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was failed. Committer: ${slackData.get(1) } "
  }
  else if( slackData.get(0)  == "SUCCESS" ) { 
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was successful. Committer: ${slackData.get(1) } "    
  }
  else if( slackData.get(0)  == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was unstable. Committer: ${slackData.get(1) } "
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} its result was unclear. Committer: ${slackData.get(1) } "	
  }
  
}
