"""
ID: jameszh1
LANG: PYTHON2
TASK: crypt1
"""
def is_number_digit_in_dict(number, dictionary):
    number_str = str(number)
    for i in range(len(number_str)):
        if (not dictionary.__contains__(int(number_str[i]))):
            return False
    return True

fin = open ('crypt1.in', 'r')
fout = open ('crypt1.out', 'w')
digit_num = int(fin.readline().strip())
number_array = fin.readline().strip().split(" ")

number_dict = dict()
for i in range(len(number_array)):
    number = int(number_array[i])
    number_dict[number] = 1

total = 0
for i in range(100, 1000):
    if (is_number_digit_in_dict(i, number_dict)):
        for j in range(10, 100):
            if (is_number_digit_in_dict(j, number_dict)):
                digit_j = j % 10
                ten_digit_j = int(j / 10)
                middle_result1 = digit_j * i
                middle_result2 = ten_digit_j * i
                if (is_number_digit_in_dict(middle_result1, number_dict) and is_number_digit_in_dict(middle_result2, number_dict) and is_number_digit_in_dict(i * j, number_dict)
                       and i * j >= 1000 and i * j < 10000 and middle_result1 > 100 and middle_result1 < 1000 and middle_result2 > 100 and middle_result2 < 1000):
                    total = total + 1



fout.write (str(total) + '\n')
fout.close()