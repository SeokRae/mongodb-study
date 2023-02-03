db.users.find({"username" : "joe", "age" : 27})
db.users.find({}, {"username" : 1, "email" : 1})
db.users.find({}, {"fatal_weakness" : 0})
db.users.find({}, {"username" : 1, "_id" : 0})
db.users.find({"age" : {"$gte" : 18, "$lte" : 30}})
start = new Date("01/01/2007")
db.users.find({"registered" : {"$lt" : start}})
db.users.find({"username" : {"$ne" : "joe"}})
db.users.find({"user_id" : {"$in" : [12345, "joe"]}})
db.users.find({"id_num" : {"$mod" : [5, 1]}})
db.users.find({"id_num" : {"$not" : {"$mod" : [5, 1]}}})
db.users.find({"name" : {"$regex" : /joe/i } })
db.users.find({"name" : /joey?/i})

//

db.foo.insertOne({"bar" : /baz/})
db.foo.find({"bar" : /baz/})

//

db.food.insertOne({"fruit" : ["apple", "banana", "peach"]})
db.food.find({"fruit" : "banana"})
db.food.insertOne({"_id" : 1, "fruit" : ["apple", "banana", "peach"]})
db.food.insertOne({"_id" : 2, "fruit" : ["apple", "kumquat", "orange"]})
db.food.insertOne({"_id" : 3, "fruit" : ["cherry", "banana", "apple"]})
db.food.find({fruit : {$all : ["apple", "banana"]}})
db.food.find({"fruit" : ["apple", "banana", "peach"]})
db.food.find({"fruit.2" : "peach"})
db.food.find({"fruit" : {"$size" : 3}})
db.food.find({"size" : {"$gt" : 3}})

//

db.blog.posts.findOne({}, {"comments" : {"$slice" : 10}})
db.blog.posts.findOne({}, {"comments" : {"$slice" : -10}})
db.blog.posts.findOne({}, {"comments" : {"$slice" : [23, 10]}})
db.blog.posts.find({"comments.name" : "bob"}, {"comments.$" : 1})

//

db.people.find({"name" : {"first" : "Joe", "last" : "Schmoe"}})
db.people.find({"name.first" : "Joe", "name.last" : "Schmoe"})

//

db.foo.insertOne({"apple" : 1, "banana" : 6, "peach" : 3})
db.foo.insertOne({"apple" : 8, "spinach" : 4, "watermelon" : 4})
db.foo.find({"$where" : function () {
        for (var current in this) {
            for (var other in this) {
                if (current != other && this[current] == this[other])
                { return true; }
            }
        }
        return false;
    }});

//

var cursor = db.people.find();
cursor.forEach(function(x) { print(x.name); });
var cursor = db.foo.find().sort({"x" : 1}).limit(1).skip(10);
var cursor = db.foo.find().limit(1).sort({"x" : 1}).skip(10);
var cursor = db.foo.find().skip(10).limit(1).sort({"x" : 1});
cursor.hasNext()

//

var page1 = db.foo.find().limit(100)
var page2 = db.foo.find().skip(100).limit(100)
var page3 = db.foo.find().skip(200).limit(100)
var page1 = db.foo.find().sort({"date" : -1}).limit(100)
var latest = null;
// display first page
while (page1.hasNext()) {
    latest = page1.next();
    display(latest);
}
// get next page
var page2 = db.foo.find({"date" : {"$lt" : latest.date}});
page2.sort({"date" : -1}).limit(100);
var total = db.foo.count()
var random = Math.floor(Math.random()*total)
db.foo.find().skip(random).limit(1)

//

db.people.insertOne({"name" : "joe", "random" : Math.random()})
db.people.insertOne({"name" : "john", "random" : Math.random()})
db.people.insertOne({"name" : "jim", "random" : Math.random()})
var random = Math.random()
result = db.people.findOne({"random" : {"$gt" : random}})