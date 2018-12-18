"""
ID: jameszh1
LANG: PYTHON2
TASK: gift1
"""
fin = open ('gift1.in', 'r')
fout = open ('gift1.out', 'w')
person_num = int(fin.readline().strip())
dic = dict()
list = []
for i in range(person_num):
    name = fin.readline().strip()
    list.append(name)
    dic[name] =  0
for i in range(person_num):
    giver_name = fin.readline().strip()
    give_info = fin.readline().split(' ')
    give_money = int(give_info[0])
    div = int(give_info[1])
    if (div != 0):
        dic[giver_name] = dic[giver_name] - give_money + give_money % div
        for j in range(div):
            receiver = fin.readline().strip()
            receive_money = give_money / div
            dic[receiver] = dic[receiver] + receive_money
for item in list:
    fout.write (item + ' ' + str(dic.get(item)) + '\n')
fout.close()