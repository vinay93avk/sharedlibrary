package com.example;

import com.example.docker.DockerConfiguration;
import com.example.steps.Steps;

class ProjectConfiguration {
    def environment;
    def services;
    Steps steps;
    def dockerfile;
    def projectName;
    def buildNumber;
    DockerConfiguration dockerConfiguration;
    def env;
    def timeout;
}
