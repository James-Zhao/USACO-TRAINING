"""
ID: jameszh1
LANG: PYTHON2
TASK: namenum
"""

fin = open ('namenum.in', 'r')
fin_dict = open('dict.txt', 'r')
fout = open ('namenum.out', 'w')
letter_to_number_dict = {'A': 2, 'B': 2, 'C': 2, 'D': 3, 'E': 3, 'F': 3, 'G': 4, 'H': 4, 'I': 4, 'J': 5, 'K': 5, 'L': 5, 'M': 6, 'N': 6, 'O': 6, 'P': 7, 'Q': 0, 'R': 7, 'S': 7, 'T': 8, 'U': 8, 'V': 8, 'W': 9, 'X': 9, 'Y': 9, 'Z': 0}
number_to_name_dict = dict()
for line in fin_dict:
    numbers = ''
    line = line.strip()
    for i in range(len(line)):
        number = letter_to_number_dict[line[i]]
        numbers = numbers + str(number)
    if number_to_name_dict.has_key(numbers):
        number_to_name_dict[numbers].append(line)
    else:
        number_to_name_dict[numbers] = list()
        number_to_name_dict[numbers].append(line)
input_number = fin.readline().strip()
if (number_to_name_dict.has_key(input_number)):
    output = number_to_name_dict[input_number]
    output.sort()
    for item in output:
        fout.write(item.strip() + '\n')
else:
    fout.write ('NONE' + '\n')
fout.close()