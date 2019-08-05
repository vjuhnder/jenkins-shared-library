#!/usr/bin/env groovy

def call(String[] slackData) {
  if ( slackData.getAt(0) == "FAILURE" ) {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was ${slackData.getAt(0)}. Committer: ${slackData.getAt(1) } "
  }
  else if( slackData.getAt(0)  == "SUCCESS" ) { 
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was ${slackData.getAt(0)}. Committer: ${slackData.getAt(1) } "    
  }
  else if( slackData.getAt(0)  == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was ${slackData.getAt(0)}. Committer: ${slackData.getAt(1) } "
  }
  else if( slackData.getAt(0)  == "ABORTED" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} was ${slackData.getAt(0)}. Committer: ${slackData.getAt(1) } "
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_DISPLAY_NAME} ${env.BUILD_URL} its result was ${slackData.getAt(0)}. Committer: ${slackData.getAt(1) } "	
  }
  
}
