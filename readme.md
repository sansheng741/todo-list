add   
given todoRequest  
when addTodo  
then TodoResponse   

delete  
give id  Todo in TodoList
when deleteTodo    
then todo not exists

queryAll    
given  void  
when queryAll  
then  all todoList  

queryFinishList
give void   
when queryFinishTodo  
then finishTodoList  

updateStatus  
given id todo(status true)  
when updateStatus  
then todo(status false) 





