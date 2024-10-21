package com.epam.google;

import java.util.*;

public class UniqueEmailAddress {
    public static void main(String[] args){
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        //String[] emails = {"testemail@leetcode.com", "testemail@leet.code.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numberOfUniqueEmail(String[] emails){
        HashMap<String, String> emailMap = new HashMap<>();
        for(String email: emails){
            int domainIndex = email.indexOf("@");
            String localName = email.substring(0,domainIndex);
            String domainName =  email.substring(domainIndex);
            if(localName.contains("+")){
                localName = localName.substring(0,localName.indexOf("+"));
            }
            emailMap.put(domainName,localName);
        }
        List<String> emailList = new ArrayList<>();
        for(Map.Entry<String, String> entry: emailMap.entrySet()){
            String localName = entry.getValue().replaceAll("\\.", "");
            String domainName = entry.getKey();
            StringBuilder actualEmail = new StringBuilder();
            actualEmail.append(localName.concat(domainName));
            if(!emailList.contains(actualEmail.toString())){
                emailList.add(actualEmail.toString());
            }
        }

        return emailList.size();
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
        for (String email : emails) {
            String[] domains = email.split("@"); // split into local and domain parts.
            String[] local = domains[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + domains[1]); // remove all '.', and concatenate '@' and domain.
        }
        return normalized.size();
    }
}
