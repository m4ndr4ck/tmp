withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'gitlab', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
sh 'git clone http://${USERNAME}:${PASSWORD}@10.129.178.173/odp/microservices/ci/stages'
}

load("stages/prep-template.groovy")