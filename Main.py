import re

def do_stuff(filename):
    highest = 0
    the_word = ""

    with open(filename) as f:
        for line in f:
            line = line.strip().split()
            for word in line:
                # cleaned_word = clean_word(word)
                cleaned_word = clean_by_regex(word)
                value = common_value(cleaned_word)
                if value > highest:
                    highest = value
                    the_word = word
    return the_word


def clean_word(word):

    word = word.lower()
    if word.isalpha():
        cleaned_word = word
    else:
        cleaned_word = ''.join(ch for ch in word if ch.isalpha())
    return cleaned_word


def clean_by_regex(word):
    return re.sub("/[^a-z]/", "", word.lower())


def common_value(word):
    highest = 0
    for ch in word:
        if word.count(ch) > highest:
            highest = word.count(ch)
    return highest


def main():
    filename = input("Enter the filename: ")
    print(do_stuff(filename))

if __name__ == '__main__':
    main()
