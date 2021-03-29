package net.lnworks.monitor.controll;

import lombok.extern.java.Log;
import net.lnworks.monitor.domain.Board;
import net.lnworks.monitor.domain.Member;
import net.lnworks.monitor.domain.StartVo;
import net.lnworks.monitor.persistence.BoardRepository;
import net.lnworks.monitor.persistence.MemberRepository;
import net.lnworks.monitor.persistence.MemberRoleRepsitory;
import net.lnworks.monitor.service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Log
@RequestMapping("/apt/")
public class StartController {
    @Autowired
    private StartService startService;

    private BoardRepository boardRepository;
    private MemberRepository memberRepository;
    private MemberRoleRepsitory memberRoleRepsitory;

    public StartController(BoardRepository boardRepository,
                           MemberRepository memberRepository,
                           MemberRoleRepsitory memberRoleRepsitory) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.memberRoleRepsitory = memberRoleRepsitory;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();

        List<StartVo> startList = startService.getStartList();

        mav.addObject("startList", startList);
        mav.setViewName("content/home.html");

        return mav;
    }

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public ModelAndView goMember(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();

        List<Member> memberlist = memberRepository.findAll();

        mav.addObject("startList", memberlist);
        mav.setViewName("content/home.html");

        return mav;
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView goBoard(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();

        //List<BoardVo> voList = boardRepository.findBoardVoByTitle("d");
        List<Board> voList = boardRepository.findAll();

        mav.addObject("startList", voList);
        mav.setViewName("content/board.html");

        return mav;
    }
}

