import unittest
from collections import defaultdict


class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)
    
    def dfs(self, start):
        "implement dfs"
        pass


class TestDfs(unittest.TestCase):
    def test(self):
        self.assertEqual('foo'.upper(), 'FOO')

if __name__ == '__main__':
    unittest.main()

