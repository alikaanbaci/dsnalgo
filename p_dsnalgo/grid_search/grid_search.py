'''
author: alikaanbaci
created date: Thursday February 27th 2020
'''
import unittest

class Grid():

    x = [-1, 0, 0, +1]
    y = [0, -1, +1, 0]
    
    def __init__(self, row, col):
        self.row = row
        self.col = col
        self.grid = arr = [[0 for i in range(col)] for j in range(row)] 
    
    def getAdjecents(self, r, c):

        adjacents = []

        for i in range(4):
            rr = self.x[i] + r
            cc = self.y[i] + c

            if (cc < 0 or rr < 0): continue
            if (cc >= self.row or rr >= self.col): continue

            adjacents.insert(0, (cc, rr))

        return adjacents

    def printGrid(self):
        print()
        for i in range(self.col):
            for j in range(self.row):
                print("(", end='')
                print(i, j, end='')
                print(")", end=' ')
            print()
    
    def bfs(self, start, end):
        path = []
        queue = []

        queue.append(start)
        self.grid[start[0]][start[1]] = 1
        self.grid[end[0]][end[1]] = 'E'

        while queue:
            
            v = queue.pop()
            path.append(v)
            
            for i in self.getAdjecents(v[0], v[1]):

                if self.grid[i[0]][i[1]] == 'E':
                    path.append(i)
                    queue.clear()
                    return path

                if self.grid[i[0]][i[1]] != 1:
                    queue.append(i)
                    self.grid[i[0]][i[1]] = 1
                    
        return path


"run test class: $ python3 -m unittest -v grid_search"
class TestGridSearch(unittest.TestCase):

    def setUp(self):
        self.g = Grid(3, 3)

    def test(self):
        self.g.printGrid()
        self.assertEqual(self.g.bfs((0,0), (2,2)), [(0, 0),(1, 0),(1, 1),(2, 1),(2, 2)])

if __name__ == '__main__':
    unittest.main()