job('Master Build and Test') {
    scm {
        git {
            remote {
                url ' http://ositechportal@bitbucket.org/ositechportal/osi-recruitment-portal.git'
		//credentials 'bbid'
		credentials 'VauId'    
		    
            }
            extensions {
                wipeOutWorkspace()
            }
            branch '*/MD_MASTER_DEV'
	    
        }
    }

    steps {
        gradle {
            tasks('clean')
            tasks('test')
            switches('-i')
            useWrapper()
        }
    }

    triggers {
	    
        scm('* * * * *') {
         //   ignorePostCommitHooks()
        }
	    bitbucketPush()
    }


    wrappers {
        colorizeOutput()
	    credentialsBinding {
            usernamePassword('MY_USERNAME','MY_PASSWORD', 'VauId')
        }
    }
}
