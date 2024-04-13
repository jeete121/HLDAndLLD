Observer Design Pattern (Notify Me)


Observable

Observer

Whenever there is state change of Observable then it will updates all the observer which are observing that observable. So that observer will perform their tasks.


ObservableInterface
 _____________________________
|add(ObserverInterface obj)   |
|remove(ObserverInterface obj)|
|notify()                     |
|setdata()                    |
|getdata()                    |
|_____________________________|
   |
   | has-a (0, *) relationship (zero to many)
   |
ObserverInterface
 _________________
|update()         |
|_________________|                  



Observable Concreate Class
 ___________________________________
|                                   |
|List<ObserverInterface> objList    |
|int data                           |
|                                   |
|add(ObserverInterface obj)         | 
|{                                  |
|   objList.add(obj)                |
|}                                  |
|remove(ObserverInterface obj)      |
|{                                  |
|   objList.remove(obj)             |
|}                                  |
|                                   |
|notify()                           |
|{                                  |
|for(ObserverInterface obj: objList)|
|   {                               |
|      obj.update()                 |
|   }                               |
|}                                  |
|                                   |
|setdata(int t)                     |
|{                                  |
|data=t                             |
|notify()                           |
|}                                  |
|___________________________________|    



Observer Concrete Class
 ________________________
|                        |
|ObservableInterface obj |
|                        |
|update()                |
|{                       |
|   obj.getdata()        |
|}                       |
|                        |
|________________________|



Example::

Weather Station Obervable  ----> TV Display Observer
Current temp                ----> Mobile Display Observer



WSObservable                                       DisplayObserver
_________________________                          ________________

add(DisplayObserver obj)                           update()
remove(DisplayObserver obj)                        ________________
notify()
setTemp()
___________________________                    MobileDisplayObserver
    |                                          ____________________
    |Implemets                                 WSObservable obj
    |                                          MobileDisplayObserver(
                                               WSObservable o)
WSObservableImpl                               {this.obj=o
_________________________                      }
List<DisplayObserver> objList                  update()
int temp                                        {obj.getdata()}
add(DisplayObserver obj)                       _____________________
{
objList.add(obj);
}
remove(DisplayObserver obj)
{
objList.remove(obj);
}

notify()
{
 for(DisplayObserver obj:objList)
   {
     obj.update()
   } 
}

setdata(int newtemp)
{
  temp=newtemp
  notify
}
__________________________
