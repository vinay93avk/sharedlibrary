package com.utils

class FileUtil implements Serializable {

   
        def steps
        public FileUtil(steps) {this.steps = steps}
        public Object readManifest() {
            // test
        }
        
        private boolean validationManifest(Object manifestData) {
            return true;
        }

        public Object readAppConfig() {
            def pipelineConfigData = steps.readYaml file: "config.yml"
            if (!validatePipelineConfig(pipelineConfigData)) {
                steps.error "config yml not found"
            }

            return pipelineConfigData
        }

        // public Object readEnvironmentsConfig() {
        //     def envConfigString = steps.libraryResource 'globalconfig.yml'
        //     dev envConfigData = steps.readYaml text: envConfigString

        //     return envConfigData
        // }
}