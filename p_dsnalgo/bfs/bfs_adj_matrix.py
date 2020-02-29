'''
author: alikaanbaci
created date: Sunday February 23rd 2020
'''
import unittest


class Graph():

    # Build adjenceny matrix
    def __init__(self, x, y):
        self.graph = []
        self.path = []

        for i in range(x):
            self.graph.append([])
            for j in range(y):
                self.graph[i].append(0)
    
    def addEdge(self, u, v):
        self.graph[u][v] = 1
        self.graph[v][u] = 1
    
    def bfs(self, start):
        visited = [False] * len(self.graph)

        queue = []

        queue.append(start)
        visited[start] = True

        while queue:

            vv = queue.pop(0)
            self.path.append(vv)

            for i in range (len(self.graph)):
                if (visited[i] == False and self.graph[vv][i] == 1):
                    queue.append(i)
                    visited[i] = True




"run test class: $ python3 -m unittest -v bfs_adj_matrix"
class TestBfs(unittest.TestCase):
    def setUp(self):
        self.g = Graph(4, 4)
        self.g.addEdge(0, 1)
        self.g.addEdge(0, 2)
        self.g.addEdge(1, 3)
        self.g.bfs(0)

    def test(self):
        self.assertEqual(self.g.path, [0, 1, 2, 3])

if __name__ == '__main__':
    unittest.main()



#print(g.graph)
