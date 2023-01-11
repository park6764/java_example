# 12주 강의 

# dict = {"강아지": "dog", "고양이": "cat", "새": "bird"}
# print(dict)
# print(dict.keys())
# print(dict.values())
# klist = list(dict.keys())
# print(klist)

# d = {'c': 1972, 'java': 1995, 'python': 1991, 'go:': 2009, 'pascal': 1969}
# print(d.keys())
# print(d.values())

# dic = {'c': 1972, 'java': 1995, 'python': 1991, 'c++': 1980}

# lang = input("언어를 입력하시오. : ")

# if(lang in dic):
#     print(dic[lang])
# else:
#     print("입력한 언어에 대한 개발 연도 정보는 없습니다.")
    
# dic['haskell'] = 1990
# dic['c#'] = 2000
# dic['R'] = 2000
# print(dic)
# del dic['python']
# print(dic)

# dic.clear()
# del dic
# print(dic)

# dic = {'kim': 111, 'park': 222, 'lee': 333}

# for i in dic.keys():
#     v = dic[i]
#     print("{0:10s} {1:10d}".format(i, v))
    
# for j in dic.items():
#     print(j)
#     print([0])
#     print([1])

# dic = {'강아지': 'dog', '고양이': 'cat', '새': 'bird', '코끼리': 'elephant'}

# while True:
#     animal = input("동물 이를을 입력하세요. : ")
    
#     if(animal == "종료"):
#         print("프로그램 종료.")
#         break
#     elif(animal in dic):
#         print(dic[animal])
#     else:
#         print("등록되지 않은 동물입니다.")

dic = {}

while True:
    menu = print("친구등록 : 1", "검색 : 2", "종료 : 0")
    choice = int(input("원하는 메뉴를 입력해주세요."))
    
    if(choice == 0):
        print("프로그램을 '종료'합니다.")
        break
    elif(choice == 1):
        name = input("이름을 입력하시오. : ")
        number = input("번호를 입력하시오. : ")
        dic[name] = number
        print("저장되었습니다.")
        print(dic)
    elif(choice == 2):
        name = input("검색할 이름을 입력하시오. : ")
        if(name in dic):
            print(dic[name])
        else:
            print("저장되지 않은 이름입니다.")