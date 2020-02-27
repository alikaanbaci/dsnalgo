import unittest
from collections import defaultdict


class Graph:
    def __init__(self):
        self.graph = defaultdict(list)
        self.vertices = []

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def dfs_util(self, v, visited):

        visited[v] = True
        self.vertices.append(v)
        
        for i in self.graph[v]:
            if (visited[i] == False):
                self.dfs_util(i, visited)
    
    def dfs(self, v):
        visited = [False] * len(self.graph)

        self.dfs_util(v, visited)

"run test calss: $ python3 -m unittest -v dfs"
class TestDfs(unittest.TestCase):
    def setUp(self):
        self.g = Graph() 
        self.g.addEdge(0, 1) 
        self.g.addEdge(0, 2) 
        self.g.addEdge(1, 2) 
        self.g.addEdge(2, 0) 
        self.g.addEdge(2, 3) 
        self.g.addEdge(3, 3) 
        self.g.dfs(2)

    def test(self):
        self.assertEqual(self.g.vertices, [2, 0, 1, 3])

if __name__ == '__main__':
    unittest.main()

