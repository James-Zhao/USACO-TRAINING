"""
ID: jameszh1
LANG: PYTHON2
TASK: barn1
"""
fin = open ('barn1.in', 'r')
fout = open ('barn1.out', 'w')
borad_num, total_stall, occupied_num = map(int, fin.readline().split(' '))
occupied_stall = list()

for i in range(occupied_num):
    number = int(fin.readline().strip())
    occupied_stall.append(number)

occupied_stall = sorted(occupied_stall)
stall_number_diff = list()
for i in range(len(occupied_stall) - 1):
    stall_number_diff.append(occupied_stall[i+1] - occupied_stall[i] - 1)

stall_number_diff = sorted(stall_number_diff, reverse=True)

total_length = occupied_stall[-1] - occupied_stall[0] + 1
for i in range(min(borad_num - 1, len(stall_number_diff))):
    total_length  = total_length - stall_number_diff[i]

fout.write (str(total_length) + '\n')
fout.close()