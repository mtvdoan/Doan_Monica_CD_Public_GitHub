SELECT * FROM reglogs;
SELECT * FROM recipes;


INSERT INTO recipes(recipe_name, recipe_description, recipe_under_30, created_at, updated_at, reglog_id)
	VALUES
		("Tamagoyaki", "Japanese sweet rolled omelette", 1, NOW(), NOW(), 1),
		("Garbage Fried Rice", "Take that leftovers", 1, NOW(), NOW(), 2),
		("Onigiri", "A simple snack on the go", 1, NOW(), NOW(), 3),
		("Animal Crackers", "A child's favorite snack", 1, NOW(), NOW(), 4),
		("Taste of the Wild", "Kibble for senior corgis", 1, NOW(), NOW(), 5);
INSERT INTO recipes(recipe_instructions) 
	VALUES
		("Fry egg mixture of (1 egg, 1 teaspoon sugar, 1 teaspoon soy sauce) in a makiyakinabe frying pan. Roll egg. Enjoy"),
        ("Take all leftovers like fries, leftover shrimp, leftover steak, 3 cups of last night's cooked white rice out of fridge. Fry in pan with sesame oil. Crack 2 eggs and stir fry. Eat" ),
        ("Mix cooked short grain sushi rice with sugar and sushi rice vinegar to taste. Mix well and mold it to a triangle. Add furikake seasoning. Yum"),
        ("Go to store. Buy animal cracker box. Open package. Enjoy"),
        ("Buy bag of Taste of the Wild Dog Food from SmartPets Store. Open bag. Place 3/4 cup of kibble in bowl. Om nom nom nom...");
UPDATE * recipes 
	SET recipe_date_made = NOW();



