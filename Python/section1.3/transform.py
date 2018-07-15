"""
ID: jameszh1
LANG: PYTHON2
TASK: transform
"""
def clockwise90(before):
    row = len(before)
    after = [([0 for i in range(row)]) for j in range(row)]
    for i in range(row):
        for j in range(row):
            after[j][row - 1 - i] = before[i][j]
    return after

def reflection(before):
    row = len(before)
    after = [([0 for i in range(row)]) for j in range(row)]
    for i in range(row):
        for j in range(row):
            after[i][j] = before[i][row - j - 1]
    return after

def check_matrix_equal(before ,after):
    row = len(before)
    for i in range(row):
        for j in range(row):
            if (before[i][j] != after[i][j]):
                return False
    return True

def is_clockwise90(before, after):
    return check_matrix_equal(clockwise90(before), after)

def is_clockwise180(before, after):
    return check_matrix_equal(clockwise90(clockwise90(before)), after)

def is_clockwise270(before, after):
    return check_matrix_equal(clockwise90(clockwise90(clockwise90(before))), after)

def is_reflection(before, after):
    return check_matrix_equal(reflection(before), after)

def is_combination(before, after):
    before = reflection(before)
    return is_clockwise90(before, after) or is_clockwise180(before, after) or is_clockwise270(before, after)

def is_noChange(before, after):
    row = len(before)
    for i in range(row):
        for j in range(row):
            if (before[i][j] != after[i][j]):
                return False
    return True

fin = open ('transform.in', 'r')
fout = open ('transform.out', 'w')
row = int(fin.readline().strip())
before = [([0 for i in range(row)]) for j in range(row)]
after = [([0 for i in range(row)]) for j in range(row)]
for i in range(row):
    line = fin.readline().strip()
    for j in range(row):
        before[i][j] = line[j]
for i in range(row):
    line = fin.readline().strip()
    for j in range(row):
        after[i][j] = line[j]

if (is_clockwise90(before, after)):
    fout.write("1" + '\n')
elif (is_clockwise180(before, after)):
    fout.write("2" + '\n')
elif (is_clockwise270(before, after)):
    fout.write("3" + '\n')
elif (is_reflection(before, after)):
    fout.write("4" + '\n')
elif (is_combination(before, after)):
    fout.write("5" + '\n')
elif (is_noChange(before, after)):
    fout.write("6" + '\n')
else:
    fout.write("7" + '\n')
fout.close()