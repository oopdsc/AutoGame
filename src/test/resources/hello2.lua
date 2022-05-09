-- local bit = require "bit"
bit = bit or {}
bit.data32 = {}

for i=1,32 do
    bit.data32[i]=2^(32-i)
end

function bit._b2d(arg)
    local nr=0
    for i=1,32 do
        if arg[i] ==1 then
            nr=nr+bit.data32[i]
        end
    end
    return  nr
end

function bit._d2b(arg)
    arg = arg >= 0 and arg or (0xFFFFFFFF + arg + 1)
    local tr={}
    for i=1,32 do
        if arg >= bit.data32[i] then
            tr[i]=1
            arg=arg-bit.data32[i]
        else
            tr[i]=0
        end
    end
    return   tr
end

function    bit._and(a,b)
    local op1=bit._d2b(a)
    local op2=bit._d2b(b)
    local r={}

    for i=1,32 do
        if op1[i]==1 and op2[i]==1  then
            r[i]=1
        else
            r[i]=0
        end
    end
    return  bit._b2d(r)

end

function    bit._rshift(a,n)
    local op1=bit._d2b(a)
    n = n <= 32 and n or 32
    n = n >= 0 and n or 0

    for i=32, n+1, -1 do
        op1[i] = op1[i-n]
    end
    for i=1, n do
        op1[i] = 0
    end

    return  bit._b2d(op1)
end

function bit._not(a)
    local op1=bit._d2b(a)
    local r={}

    for i=1,32 do
        if  op1[i]==1   then
            r[i]=0
        else
            r[i]=1
        end
    end
    return bit._b2d(r)
end

function bit._or(a,b)
    local op1=bit._d2b(a)
    local op2=bit._d2b(b)
    local r={}

    for i=1,32 do
        if op1[i]==1 or op2[i]==1  then
            r[i]=1
        else
            r[i]=0
        end
    end
    return bit._b2d(r)
end

bit.band   = bit.band or bit._and
bit.rshift = bit.rshift or bit._rshift
bit.bnot   = bit.bnot or bit._not


local transcoder =  {}
-- 无返回对象的调用情况
function helloWithoutTranscoder()
print 'hello, sky -- no transcoder '
end
-- 无参
function transcoder.hello()
print 'hello'
return 'hello, sky'
end

-- 无参
function transcoder.hello3()
local ts = os.time()
print(ts)
print(tostring(ts))
print(string.sub(tostring(ts),3))
print('xxx:'..tonumber(string.sub(tostring(ts),3)))
return 'hello, sky'
end

--
-- function transcoder.hello2()
--     local ts = os.time()
--     local rand = math.random(1,3)
--     local codeRand = math.random(1,9)
--     local codeArr = {
--         {'u','t','k','q','a','b','r','e','i','w'},
--         {'q','a','y','m','x','n','b','w','h','l'},
--         {'p','h','e','z','f','k','n','r','w','s'},
--         {'g','c','f','a','m','i','v','h','b','x'},
--         {'h','w','y','j','f','p','e','v','r','a'},
--         {'b','w','x','s','g','u','y','p','k','l'},
--         {'l','c','y','x','g','o','v','s','p','d'},
--         {'o','a','m','j','k','r','i','v','e','x'},
--         {'t','r','m','z','s','n','c','j','i','b'}
--     }
--     local cTime = string.sub(tostring(ts),3)
--     local ltime = bit.lshift(tonumber(cTime), rand)
--     local atime = rand..ltime
--     local cipher = ""
--     local len = #atime
--     for i=1,len do
--         local index = tonumber(string.sub(atime,i,i)) + 1
--         local s = codeArr[codeRand][index]
--         cipher = cipher..s
--     end
--     return codeRand..cipher
-- end



-- 参数为string数据
function transcoder.test(str)
print('data from java is:'..str)
return 'the parameter is '..str
end
-- 返回一个lua对象
function transcoder.getInfo()
   return {
        ['userId'] = '9999',
        ['services'] =
            {{
                'eat',
                'drink'
            }, {
                'eat2',
                'drink2'
            }}
    }
end
--[[
   infoObj-json示例:
        {
            'userId': '1111',
            'services': [{
               '0' : 'eat-test',
               '1' : 'drink-test'
            }]
      }
--]]
-- 传入一个lua对象
function transcoder.readInfo(infoObj)
   return infoObj.userId
end

return transcoder