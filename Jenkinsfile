// Jenkinsfile - Scripted Pipeline for DEVOPS-SETB (Windows)
node {
    try {
        stage('Checkout') {
            echo "Cloning repository from GitHub..."
            checkout([$class: 'GitSCM',
                branches: [[name: '*/main']],
                userRemoteConfigs: [[url: 'https://github.com/sharvari31/spring-petclinic.git']]
            ])
        }

        stage('Build') {
            echo "Building the project using Maven..."
            bat "${tool 'M3'}\\bin\\mvn clean package -DskipTests=false"
        }

        stage('Test') {
            echo "Running unit tests..."
            bat "${tool 'M3'}\\bin\\mvn test"
            junit '**/target/surefire-reports/*.xml'
        }

        stage('Archive Artifacts') {
            echo "Archiving build output..."
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }

    } catch (err) {
        currentBuild.result = 'FAILURE'
        echo "Build failed: ${err}"
        throw err
    } finally {
        echo "Cleaning workspace..."
        cleanWs()
    }
}
