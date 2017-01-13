def main
  puts 'Enter the filename: '
  filename = gets.chomp
  puts do_stuff filename

end

def do_stuff(filename)
  highest = 0
  the_word = 'default'
  File.open(filename).each do |line|
    line.split.each do |word|
      value = common_value(clean_word(word))
      if value > highest
        highest = value
        the_word = word
      end
    end
  end
  the_word
end

def common_value(word)
  values = Hash.new
  highest = 1

  word.each_char do |ch|
    if values.has_key? ch
      value = values[ch]+1
      values[ch] = value
      if value > highest
        highest = value
      end
    else
      values[ch] = 1
    end
  end

  highest
end

def clean_word(word)
  word.downcase.gsub(/[^a-z]/, '')
end

main

