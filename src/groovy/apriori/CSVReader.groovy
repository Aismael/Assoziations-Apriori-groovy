package groovy.apriori

import java.lang.reflect.Array

/**
 * Created by aisma on 18.05.2016.
 */
class CSVReader {
    def path
    def headers;
    ArrayList body=new ArrayList<>();
    def read(){
        new File(path).getText('UTF-8').eachLine { String line,lineIndex->
            line=line+";1"
            if(lineIndex) {
                lineIndex++
                body[lineIndex-1]=line.split(';').collect{if(it)(((it.replaceAll(",","\\.")) as double)*10)as int else "" }.drop(1).dropRight(1)
                println body[lineIndex-1].size()+":::"+  body[lineIndex-1]
            }else{
                lineIndex++
                headers=line.tokenize(';').drop(1)

            }
        }
        return [path,headers,body]
    }
}

