import hashlib

def letterCasePermutation(S):
    B = sum(letter.isalpha() for letter in S)

    for bits in range(1 << B):
        b = 0
        word = []
        for letter in S:
            if letter.isalpha():
                if (bits >> b) & 1:
                    word.append(letter.lower())
                else:
                    word.append(letter.upper())

                b += 1
            else:
                word.append(letter)
        if(hashlib.md5("".join(word).encode('utf-8')).hexdigest()=="7513209051f455fa44d0fa5cd0f3e051"):
            print("".join(word))

letterCasePermutation(input())