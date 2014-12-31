=begin
Text Manipulation

In this challenge you will have to perform some text operations.
You need to replace all occurrences of string “Java” by “PHP” and capitalize the first character of each word 
(if the word is in upercase make it lowercase and then capitalize it. So HTML becomes Html). After that, all 
phrases inside the string of text need to be splitted in several paragraphs. Finally, the paragraphs need to 
be displayed in screen by alphabetic order.

Note:
Each paragraph is defined by a period (.) and there will not be other types of final pontuation or ellipsis
Separate each paragraph with a <br/> tag

Input Format
Each test case contains a string of text.

Output Format
For each test case output the string of text splitted in several paragraphs.

Sample Input
Java is a server-side scripting language. Java code can be simply mixed with HTML code. After the Java code is 
interpreted and executed, the web server sends resulting output to its client.
Sample Output
After The Php Code Is Interpreted And Executed, The Web Server Sends Resulting Output To Its Client.<br/>Php 
Code Can Be Simply Mixed With Html Code.<br/>Php Is A Server-side Scripting Language.

Memory Limit
512M
=end

input = gets
paragraphs = input.split "." 
paragraphs.delete "\n"
result_array = Array.new 

#print paragraphs

paragraphs.each do |paragraph|
  result_string = String.new
  paragraph.gsub! "Java", "PHP" 
  
  words = paragraph.split 
  
  words.each do |word|
      word.downcase!
      word.capitalize! 
    
    if result_string.size == 0
      result_string << word
    else
      result_string << " "
      result_string << word
    end 
      
  end 
  
  result_string << '.<br/>'
  result_array.push result_string
  
end

last = result_array.size - 1
result_array.sort!
result_array[last].slice! '<br/>'

result_array.each do |paragraph|
  print paragraph
end
  






