local transcoder =  {}

local bit = require "bit"
function transcoder.encryptTime()

    local ts = os.time()
    local rand = math.random(1,3)
    local codeRand = math.random(1,9)
    local codeArr = {
        {'u','t','k','q','a','b','r','e','i','w'},
        {'q','a','y','m','x','n','b','w','h','l'},
        {'p','h','e','z','f','k','n','r','w','s'},
        {'g','c','f','a','m','i','v','h','b','x'},
        {'h','w','y','j','f','p','e','v','r','a'},
        {'b','w','x','s','g','u','y','p','k','l'},
        {'l','c','y','x','g','o','v','s','p','d'},
        {'o','a','m','j','k','r','i','v','e','x'},
        {'t','r','m','z','s','n','c','j','i','b'}
    }
    local cTime = string.sub(tostring(ts),3)
    local ltime = bit.lshift(tonumber(cTime), rand)
    local atime = rand..ltime
    local cipher = ""
    local len = #atime
    for i=1,len do
        local index = tonumber(string.sub(atime,i,i)) + 1
        local s = codeArr[codeRand][index]
        cipher = cipher..s
    end
    return codeRand..cipher
end