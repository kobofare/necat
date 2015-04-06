# necat
# how to create a maven project and push the project to remote github.
please follow as: http://blog.sonatype.com/2009/09/maven-tips-and-tricks-using-github/#.VSAJS2CSw8o

if you want to add maven project to github repository, you can follow as:
1, create a github repository on you github.
2, change current directory into you maven project which you want to push to github.
3, execute "maven clean" to clean the compiling files.
3, execute "git init" to create local git repository.
4, execute "git add . -A" to tell git the files that we want to push to github.
5, execute "git commit -m <comments>" to add the files to local repository.
6, execute "git remote add origin <github path>" to build the relationship between remote github and local github.
7, execute "git push origin master" to push the files to remote github.

# how to config maven module.
please follow as: http://books.sonatype.com/mvnex-book/reference/multimodule-sect-simple-parent.html
