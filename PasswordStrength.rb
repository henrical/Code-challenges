=begin
The Password Strength

In this challenge you will receive a string containing a password that the user is trying to set and you will have to make sure that password is valid and secure. The criterias are:

- At least six characters
- No white spaces
- At least one capital letter
- At least one number
- At least one symbol
- Only the following symbols are allowed: $ # - _ &

Input Format
Each test case contains a string with a password.

Output Format
For each test case output "Valid" if the password is valid and secure or "Invalid" if not.

Sample Inputs
mypassword123
#Some_Pass1#

Sample Outputs
Invalid
Valid

Memory Limit
512M

=end
$INVALID = "Invalid"
$VALID = "Valid"
$PERMITTED_SYMBOLS = ["$","#","-","_","&"]

class String

  def is_valid_password?
    #Minumum length test
    if self.size < 6
      return $INVALID
    end
    
    #Capital letter test
    has_capital_letter = false
    characters = self.chars.to_a
    
    characters.each do |char|
      if(char == char.capitalize)
	has_capital_letter = true
	break
      end
    end
    
    unless(has_capital_letter)
      return $INVALID
    end
    
    #Blank spaces test
    if self.include? ' '
      return $INVALID
    end
    
    #Contains number test
    unless self.count("0-9") > 0
      return $INVALID
    end
    
    #Contains Symbol test
    has_symbol = false
    
    $PERMITTED_SYMBOLS.each do |symbol|
      if self.include? symbol
	has_symbol = true
	break
      end
    end
    
    unless(has_symbol)
      return $INVALID
    end
    
    #finally, if every test passes
    return $VALID  
    
  end

end

input = gets.chomp

puts input.is_valid_password?