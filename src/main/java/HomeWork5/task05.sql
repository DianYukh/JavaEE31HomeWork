# 1. Вивести кількість викладачів кафедри «Математики».
select count(*) from teachers
join academyhw3.lectures l on teachers.id_teachers = l.teachersId
join academyhw3.groups_lectures gl on l.id_lectures = gl.lecturesId
join academyhw3.`groups` g on gl.groupsId = g.id_groups
join academyhw3.departments d on g.departmentsId = d.id_departments
where d.name='математики';

# 2. Вивести кількість лекцій, які читає викладач “Ірина Коваленко”.
select count(*) from subjects
join academyhw3.lectures l on subjects.id_subjects = l.subjectsId
join academyhw3.teachers t on t.id_teachers = l.teachersId
where t.name='Ірина' and t.surname='Коваленко';

# 3. Вивести кількість занять, які проводяться в аудиторії “102”.
select count(*) from subjects
join academyhw3.lectures l on subjects.id_subjects = l.subjectsId
where lecturesRoom='102';

# 4. Вивести назви аудиторій та кількість лекцій, що проводяться в них.
select lectures.lecturesRoom, count(*) from lectures
join academyhw3.subjects s on s.id_subjects = lectures.subjectsId
group by lectures.lecturesRoom;


# 6. Вивести середню ставку викладачів Фізико-математичного факультету .
select sum(salary) from teachers
join academyhw3.lectures l on teachers.id_teachers = l.teachersId
join academyhw3.groups_lectures gl on l.id_lectures = gl.lecturesId
join academyhw3.`groups` g on gl.groupsId = g.id_groups
join academyhw3.departments d on g.departmentsId = d.id_departments
join academyhw3.faculties f on d.facultyId = f.id_faculties
where f.name='фізико-математичний';

# 8. Вивести середній фонд фінансування кафедр.
select avg(financing) from departments;

# 9. Вивести повні імена викладачів та кількість читаних ними дисциплін.
select teachers.name, teachers.surname, count(*) from teachers
join academyhw3.lectures l on teachers.id_teachers = l.teachersId
join academyhw3.subjects s on l.subjectsId = s.id_subjects
group by teachers.name, teachers.surname;

# 12.Вивести назви факультетів та кількість дисциплін, які на них читаються
select f.name, count(*) from subjects
join academyhw3.lectures l on subjects.id_subjects = l.subjectsId
join academyhw3.groups_lectures gl on l.id_lectures = gl.lecturesId
join academyhw3.`groups` g on gl.groupsId = g.id_groups
join academyhw3.departments d on g.departmentsId = d.id_departments
join academyhw3.faculties f on f.id_faculties = d.facultyId
group by f.name;