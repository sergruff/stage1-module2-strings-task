package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder builder = new StringBuilder();
        for (String s :
                delimiters) {
            builder.append(s);
        }
        StringTokenizer st = new StringTokenizer(source, builder.toString(), false);
        List<String> resultList = new ArrayList<>();
        while (st.hasMoreTokens()){
            resultList.add(st.nextToken());
        }
        return resultList;
    }
}
