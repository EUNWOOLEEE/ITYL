

——————————— 문제1 ———————————
use tutorial

db.users.insert({username : ‘smith’})
db.users.insert({username : ‘jones’})

db.users.find()
db.users.findOne()


——————————— 문제2 ———————————
db.users.find({username : 'jones'})
db.users.find({$or : [{username : 'jones'}, {username : 'smith'}]})


——————————— 문제3 ———————————
db.users.update({username : 'smith'}, {$set : {country : 'Canada'}})
db.users.find({username : 'smith'})


——————————— 문제4 ———————————
db.users.replaceOne({username : 'smith'}, {country : 'Canada'})
db.users.replaceOne({country : 'Canada'}, {username : 'smith', country : 'Canada'})


——————————— 문제5 ———————————
db.users.update({username : 'smith'}, {$unset : {country : 1}})
db.users.find()


——————————— 문제6 ———————————
show databases
show collections
db.stats()
db.users.stats()


——————————— 문제7 ———————————
db.users.remove({username : 'smith'})
db.users.remove({})
db.users.drop()


——————————— 문제8 ———————————
for(let i = 0; i < 20000; i++) {
	db.product.insert({
		num: i,
		name: '스마트폰 ' + i
	});
}
db.product.count()


——————————— 문제9 ———————————
db.product.find().sort({num : -1})
db.product.find().sort({num : -1}).limit(10)
db.product.find().sort({num : -1}).skip(6 * 10).limit(10)


——————————— 문제10 ———————————
db.product.find({$or : [{num : {$lt : 15}}, {num : {$gt : 19995}}]})
db.product.find({name : {$in : ['스마트폰 10', '스마트폰 100', '스마트폰 1000']}})


——————————— 문제11 ———————————
db.product.find({num : {$lt : 5}}, {name : 1, _id : 0})
