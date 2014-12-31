=begin
Using The Force, The Brute Force

In this challenge you will be a hacker trying to find out a password from a hash you got from a database.

During the database hacking you also got some extra information that will be very usefull to get this password:

- The password encryption is md5
- The maximum password length is 4 because it's a pin number
- The password can only have the following charaters [a, b, c, 0, 1, 2, 3] (it's a weird pin pad)

Let the hacking begin!

Input Format
Each input will be a string with a hash like: "81b5dd04bf5cbc172eeb34bb8062fde1"

Output Format
The output should be a string with the password

Sample Input
81b5dd04bf5cbc172eeb34bb8062fde1

Sample Output
a23c

Memory Limit
512M 
=end
require 'digest/md5'

class String
  
  #Create an array with all the permutations of length 4 of a given string
  def all_permutations 
    return self.chars.to_a.permutation(4).map(&:join)
  end
  
end

input = gets.chomp

permutations = "abc0123".all_permutations

permutations.each do |perm|
  password = Digest::MD5.hexdigest(perm)
  if(password==input)
    puts perm
  end
end 















