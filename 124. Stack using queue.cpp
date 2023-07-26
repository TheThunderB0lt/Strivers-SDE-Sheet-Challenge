class Stack {

private:

// Define the data members.

queue<int> q;

 

public:

Stack() {

// Implement the Constructor.

}

 

/*----------------- Public Functions of Stack -----------------*/

 

int getSize() {

// Implement the getSize() function.

return q.size();

}

 

bool isEmpty() {

// Implement the isEmpty() function.

return q.empty();

}

 

void push(int x) {

q.push(x);

for (int i = 0; i < q.size() - 1; i++) {

q.push(q.front());

q.pop();

}

}

 

int pop() {

// Implement the pop() function.

if(q.size() == 0) { return -1; }

int val = q.front();

q.pop();

return val;

}

 

int top() {

// Implement the top() function.

if(q.size() == 0) { return -1; }

return q.front();

}

};