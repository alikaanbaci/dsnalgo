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
        self.grid = [[0] * col] * row 
    
    def getAdjecents(self, r, c):

        adjacents = []

        for i in range(4):
            rr = self.x[i] + r
            cc = self.y[i] + c

            if (cc < 0 or rr < 0): continue
            if (cc >= self.row or rr >= self.col): continue

            adjacents.append((cc, rr))

        return adjacents


"run test calss: $ python3 -m unittest -v grid_search"
class TestGridSearch(unittest.TestCase):

    def setUp(self):
        self.g = Grid(3, 3)

    def test(self):
        self.assertEqual(self.g.getAdjecents(2, 2), [(2, 1), (1, 2)])

if __name__ == '__main__':
    unittest.main()