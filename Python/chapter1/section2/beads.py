"""
ID: jameszh1
LANG: PYTHON2
TASK: beads
"""
fin = open ('beads.in', 'r')
fout = open ('beads.out', 'w')
number_of_bead = int(fin.readline().strip())
necklace = fin.readline().strip()
necklace = necklace + necklace
left = [([0 for row in range(2)]) for row in range(800)]
right = [([0 for col in range(2)]) for row in range(800)]

for i in range(1, 2 * number_of_bead + 1, 1):
    if (necklace[i - 1] == 'r'):
        left[i][0] = left[i - 1][0] + 1
        left[i][1] = 0
    elif (necklace[i - 1] == 'b'):
        left[i][1] = left[i - 1][1] + 1
        left[i][0] = 0
    else:
        left[i][0] = left[i - 1][0] + 1
        left[i][1] = left[i - 1][1] + 1

for i in range(2 * number_of_bead - 1, -1, -1):
    if (necklace[i] == 'r'):
        right[i][0] = right[i + 1][0] + 1
        right[i][1] = 0
    elif (necklace[i] == 'b'):
        right[i][1] = right[i + 1][1] + 1
        right[i][0] = 0
    else:
        right[i][0] = right[i + 1][0] + 1
        right[i][1] = right[i + 1][1] + 1
m = 0
for i in range(0, 2 * number_of_bead):
    m = max(m, max(left[i][0], left[i][1]) + max(right[i][0], right[i][1]))
m = min(m, number_of_bead)
fout.write (str(m) + '\n')
fout.close()