#!/usr/bin/env groovy
import com.test.pipeline.ConstantsGeneric

def call(String buildStyle, Map config=[:]) {

} 


withEnv([
        "PROJECT_FOLDER=${constantsGeneric.projectFolder}",
    ]) {
        body()
    } 
    
def pipeline(config) {
    stage('Build') {
        sh '''  
            ls ${PROJECT_FOLDER}                      
        '''
    }

    stage('Database') {
        sh '''
            cat ${K8S_DEPLOYMENT_FILE_PATH}
            
        '''
    }
    stage('Deploy') {
        sh '''
            cat ${K8S_DEPLOYMENT_FILE_PATH}
            
        '''
    }
    stage('Test') {
        sh '''
            cat ${K8S_DEPLOYMENT_FILE_PATH}
            
        '''
    }
    stage('Notifications') {
        sh '''
            cat ${K8S_DEPLOYMENT_FILE_PATH}
            
        '''
    }
    stage('Cleanup') {
        sh '''
            cat ${K8S_DEPLOYMENT_FILE_PATH}
            
        '''
    }
}
